package com.prodapt.mulesoft.connectors.matrixx.internal.error.exception;

import java.io.InputStream;

import org.mule.runtime.api.metadata.MediaType;
import org.mule.runtime.core.api.util.IOUtils;
import org.mule.runtime.extension.api.runtime.operation.Result;
import org.mule.runtime.http.api.domain.entity.HttpEntity;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prodapt.mulesoft.connectors.matrixx.api.HttpResponseAttributes;
import com.prodapt.mulesoft.connectors.matrixx.internal.error.MatrixxErrorTypes;


public class ExceptionHandler {
	/*
	 * private static final Logger logger =
	 * LoggerFactory.getLogger(ExceptionHandler.class);
	 * 
	 * public static final void checkErrorResponse(HttpResponse httpResponse) { int
	 * status = httpResponse.getStatusCode(); if (status != 200 && status != 201) {
	 * String errorResponse = null; InputStream inputStream =
	 * httpResponse.getEntity().getContent(); if (inputStream != null) errorResponse
	 * = IOUtils.toString(inputStream); throw new MatrixxException(errorResponse,
	 * toResult(httpResponse, errorResponse), getError(Integer.valueOf(status))); }
	 * }
	 * 
	 * public static final MatrixxErrorTypes resolveError(Throwable error) { if (error
	 * instanceof java.util.concurrent.TimeoutException) return
	 * MatrixxErrorTypes.TIMEOUT; if
	 * (error.getMessage().equalsIgnoreCase("Remotely closed")) return
	 * MatrixxErrorTypes.REMOTELY_CLOSED; return MatrixxErrorTypes.CONNECTIVITY; }
	 * 
	 * public static final MatrixxErrorTypes getError(Integer status) { return
	 * MatrixxErrorTypes.valueOf(status.toString()); }
	 * 
	 * public static Result<String, HttpResponseAttributes> toResult(HttpResponse
	 * httpResponse, String errorPayload) { Result.Builder<String,
	 * HttpResponseAttributes> builder = Result.builder(); HttpEntity entity =
	 * httpResponse.getEntity(); builder.output(errorPayload);
	 * entity.getLength().ifPresent(length -> builder.length(length.longValue()));
	 * String contentType = (String)httpResponse.getHeaders().get("Content-Type");
	 * if (contentType != null) try {
	 * builder.mediaType(MediaType.parse(contentType)); } catch (Exception var9) {
	 * if (logger.isDebugEnabled()) logger.debug(String.
	 * format("Response Content-Type '%s' could not be parsed to a valid Media Type. Will ignore"
	 * , new Object[] { contentType }), var9); }
	 * builder.attributes(toAttributes(httpResponse)).attributesMediaType(MediaType.
	 * APPLICATION_JAVA); return builder.build(); }
	 * 
	 * private static HttpResponseAttributes toAttributes(HttpResponse response) {
	 * return new HttpResponseAttributes(response.getStatusCode(),
	 * response.getReasonPhrase(), response.getHeaders()); }
	 */
}
