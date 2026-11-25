/*
 * Copyright 2013-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.gateway.server.mvc.filter;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.cloud.gateway.server.mvc.filter.AfterFilterFunctions.addResponseHeader;

class AfterFilterFunctionsUnitTests {

	@Test
	void addResponseHeaderSupportsStandardServerResponse() {
		ServerRequest request = ServerRequest.create(new MockHttpServletRequest(), Collections.emptyList());
		ServerResponse response = ServerResponse.ok().build();

		ServerResponse result = addResponseHeader("X-Test", "test-value").apply(request, response);

		assertThat(result.headers().getFirst("X-Test")).isEqualTo("test-value");
	}

}
