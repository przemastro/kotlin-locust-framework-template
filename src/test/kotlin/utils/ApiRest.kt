package utils

import io.restassured.RestAssured
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import utils.Configuration.dataModel


open class ApiRest {

    private var lastResponse: Response? = null
    private var lastRequestBody: String? = null

    /**
     * Sends request to given endpoint.
     *
     * @param method   HTTP method to be used.
     * @param endpoint Endpoint to be called.
     * @param body     Body to be attached to request.
     * @param token    Authorization token to be used.
     */
    open fun request(apiUrl: String, method: String, endpoint: String, body: String, token: String) {
        val requestUrl: String = apiUrl + endpoint
        lastRequestBody = body
        val request: RequestSpecification = RestAssured.given()
        request.accept("*/*")

        if (body != "") {
            val map = body.split(",").associateTo(HashMap()) {
                val (left, right) = it.split("=")
                left to right
            }
            map.forEach { (key, value) -> request.formParam("$key", "$value") }
            request.header("Content-Type", "application/x-www-form-urlencoded")
        }

        if (token != "") {
            request.header("Authorization", "Bearer $token")
        }

        lastResponse = when (method.toUpperCase()) {
            "GET" -> request.get(requestUrl)
            "HEAD" -> request.head(requestUrl)
            "POST" -> request.post(requestUrl)
            "PUT" -> request.put(requestUrl)
            "DELETE" -> request.delete(requestUrl)
            "OPTIONS" -> request.options(requestUrl)
            "PATCH" -> request.patch(requestUrl)
            else -> null
        }
    }

    /**
     * Sends request to given endpoint.
     *
     * @param method   HTTP method to be used.
     * @param endpoint Endpoint to be called.
     */
    open fun request(method: String, endpoint: String) {
        request(dataModel().apiUrl, method, endpoint, "", "")
    }

    /**
     * Sends request to given endpoint.
     *
     * @param url   HTTP url to be used.
     * @param method   HTTP method to be used.
     * @param endpoint Endpoint to be called.
     * @param body  HTTP body to be used.
     */
    open fun request(url: String, method: String, endpoint: String, body: String) {
        request(url, method, endpoint, "", "")
    }

    /**
     * Sends request to given endpoint.
     *
     * @param method   HTTP method to be used.
     * @param endpoint Endpoint to be called.
     */
    open fun request(method: String, endpoint: String, body: String) {
        request(dataModel().apiUrl, method, endpoint, body, "")
    }

    /**
     * Returns last HTTP response.
     *
     * @return lastResponse variable.
     */
    open fun getLastResponse(): Response? {
        return lastResponse
    }

}
