/*
 * Copyright 2024-2025 the original author or authors.
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

package org.springframework.ai.chat.memory.mongodb;

import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

/**
 * @author Łukasz Jernaś
 */
public class MongoDbChatMemoryConfigTest {

	@Test
	void setValues() {
		var mongoClient = mock(MongoTemplate.class);
		var config = MongoDbChatMemoryConfig.builder().withTemplate(mongoClient).build();

		assertThat(config.mongoTemplate).isEqualTo(mongoClient);

	}

	@Test
	void buildWithNullMongoTemplate_shouldThrow() {
		assertThatThrownBy(() -> MongoDbChatMemoryConfig.builder().build());
	}

}
