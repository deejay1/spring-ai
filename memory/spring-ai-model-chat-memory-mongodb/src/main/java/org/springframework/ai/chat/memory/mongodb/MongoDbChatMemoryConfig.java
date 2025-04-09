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

import org.jspecify.annotations.NonNull;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.util.Assert;

/**
 * Configuration for {@link MongoDbChatMemory}.
 *
 * @author Łukasz Jernaś
 * @since 1.0.0
 */
public class MongoDbChatMemoryConfig {

	final MongoTemplate mongoTemplate;

	private MongoDbChatMemoryConfig(Builder builder) {
		this.mongoTemplate = builder.mongoTemplate;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {

		private MongoTemplate mongoTemplate = null;

		private Builder() {
		}

		public Builder withTemplate(@NonNull MongoTemplate mongoTemplate) {
			Assert.notNull(mongoTemplate, "MongoTemplate must not be null");

			this.mongoTemplate = mongoTemplate;
			return this;
		}

		public MongoDbChatMemoryConfig build() {
			Assert.notNull(this.mongoTemplate, "MongoTemplate must not be null");

			return new MongoDbChatMemoryConfig(this);
		}

	}

}
