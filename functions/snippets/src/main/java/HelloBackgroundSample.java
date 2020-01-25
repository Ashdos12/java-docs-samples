/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// [START functions_background_helloworld]
import java.util.logging.Logger;

import com.google.cloud.functions.BackgroundFunction;
import com.google.cloud.functions.Context;
import com.google.cloud.functions.HttpRequest;

public class HelloBackgroundSample implements BackgroundFunction<HttpRequest> {
  private static final Logger LOGGER = Logger.getLogger(HelloBackgroundSample.class.getName());

  @Override
  public void accept(HttpRequest request, Context context) {
    String name = "world";
    if (request.getFirstQueryParameter("name").isPresent()) {
      name = request.getFirstQueryParameter("name").get();
    }
    LOGGER.info(String.format("Hello %s!", name));
  }
}
// [END functions_background_helloworld]