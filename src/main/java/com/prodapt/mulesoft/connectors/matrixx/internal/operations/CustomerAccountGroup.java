package com.prodapt.mulesoft.connectors.matrixx.internal.operations;


	

	import java.io.ByteArrayInputStream;
	import java.io.InputStream;
	

	import org.mule.runtime.api.metadata.DataType;
	import org.mule.runtime.api.metadata.TypedValue;
	import org.mule.runtime.extension.api.annotation.param.Config;
	import org.mule.runtime.extension.api.annotation.param.Connection;
	import org.mule.runtime.extension.api.annotation.param.Content;
	import org.mule.runtime.extension.api.annotation.param.MediaType;
	import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
	import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
	import org.mule.runtime.extension.api.annotation.param.display.Summary;
	import org.mule.runtime.extension.api.runtime.operation.Result;
	import org.mule.runtime.extension.api.runtime.process.CompletionCallback;
	import org.mule.runtime.extension.api.runtime.streaming.StreamingHelper;
	import org.mule.runtime.http.api.HttpConstants;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import com.prodapt.mulesoft.connectors.matrixx.api.HttpResponseAttributes;
	import com.prodapt.mulesoft.connectors.matrixx.api.operation.RequestParameters;
	import com.prodapt.mulesoft.connectors.matrixx.internal.configuration.RestConfiguration;
	import com.prodapt.mulesoft.connectors.matrixx.internal.configuration.parametergroup.ConfigurationOverrides;
	import com.prodapt.mulesoft.connectors.matrixx.internal.configuration.parametergroup.EntityRequestParameters;
	import com.prodapt.mulesoft.connectors.matrixx.internal.connection.MatrixxConnection;
	import com.prodapt.mulesoft.connectors.matrixx.internal.utility.MatrixxUtility;
	import com.prodapt.mulesoft.connectors.matrixx.internal.utility.RestRequestBuilder;

	public class  CustomerAccountGroup {

		private static final Logger logger = LoggerFactory.getLogger(CustomerAccountGroup.class);
		public static final RestRequestBuilder.QueryParamFormat QUERY_PARAM_FORMAT = RestRequestBuilder.QueryParamFormat.MULTIMAP;

		@DisplayName("Create Customer Account Group")
		@MediaType(value = "application/json")
		@Summary("Create Customer Account Group")
		public void  createcustomeraccountGroup(@Config RestConfiguration rc, @Connection MatrixxConnection connection,
				@ParameterGroup(name = "Request Parameters") EntityRequestParameters parameters,
				@ParameterGroup(name = "Connector Overrides") ConfigurationOverrides overrides,
				@Content(primary = true) TypedValue<InputStream> payload, StreamingHelper streamingHelper,
				CompletionCallback<InputStream, HttpResponseAttributes> callback) {

			String resourcePath = "/data/json";
			String jsonString = MatrixxUtility.getJSONPayload(payload).toString();
			logger.info("URL :: {} :::: Payload :: {}", (connection.getBaseURL() + resourcePath), jsonString);

			InputStream payloadInputStream = new ByteArrayInputStream(jsonString.getBytes());
			TypedValue<InputStream> payloadTypedValue = new TypedValue<InputStream>(payloadInputStream,
					DataType.INPUT_STREAM);
			RestRequestBuilder builder = new RestRequestBuilder(connection.getBaseURL(), resourcePath, HttpConstants.Method.POST,
					(RequestParameters) parameters).setQueryParamFormat(QUERY_PARAM_FORMAT)
							.addHeader("Content-Type", "application/json").addHeader("accept", "application/json")
							.setBody(payloadTypedValue, overrides.getStreamingType());
			try {
				connection.request(builder, 0, null, streamingHelper).whenComplete(MatrixxUtility.handleResponse(callback));
			} catch (Throwable t) {
				t.printStackTrace();
				callback.error(t);
			}
		}
	}


