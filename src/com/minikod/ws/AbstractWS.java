package com.minikod.ws;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.minikod.exception.WSServiceException;

/**
 * 
 * @author CaYLaK
 * 
 */
public class AbstractWS {

	protected String SOAP_ACTION = null;
	protected String METHOD_NAME = null;
	protected String NAMESPACE = null;
	protected String URL = null;
	protected String TAG = null;
	protected String ResultMessage = null;
	protected String SuccessCode = null;
	protected String ErrorCode = null;

	public AbstractWS() {

	}

	public AbstractWS(String SOAP_ACTION, String METHOD_NAME, String NAMESPACE,
			String URL, String SuccessCode, String ErrorCode,
			String ResultMessage) {
		this.SOAP_ACTION = SOAP_ACTION;
		this.METHOD_NAME = METHOD_NAME;
		this.NAMESPACE = NAMESPACE;
		this.URL = URL;
		this.SuccessCode = SuccessCode;
		this.ErrorCode = ErrorCode;
		this.ResultMessage = ResultMessage;
	}

	public Object execute(SoapObject request) throws WSServiceException {
		Object response = null;
		try {
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION, envelope);
			response = envelope.getResponse();
			SoapObject bodyIn = (SoapObject) envelope.bodyIn;
			Object result = bodyIn.getProperty(ResultMessage);
			if (result == null
					|| (result.toString().length() > 0 && !result.toString()
							.equalsIgnoreCase(SuccessCode))
					&& result.toString().equalsIgnoreCase(ErrorCode)) {
				throw new WSServiceException(result.toString());
			}
		} catch (Exception e) {
			throw new WSServiceException(e.toString());
		}
		return response;
	}

	public String getSOAP_ACTION() {
		return SOAP_ACTION;
	}

	public void setSOAP_ACTION(String sOAP_ACTION) {
		SOAP_ACTION = sOAP_ACTION;
	}

	public String getMETHOD_NAME() {
		return METHOD_NAME;
	}

	public void setMETHOD_NAME(String mETHOD_NAME) {
		METHOD_NAME = mETHOD_NAME;
	}

	public String getNAMESPACE() {
		return NAMESPACE;
	}

	public void setNAMESPACE(String nAMESPACE) {
		NAMESPACE = nAMESPACE;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

}
