/*
 * Copyright (C) 2015 Strand Life Sciences.
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

package com.strandls.alchemy.webservices.auth;

import com.google.inject.AbstractModule;
import com.google.inject.servlet.ServletScopes;
import com.strandls.alchemy.inject.AlchemyModule;
import com.strandls.alchemy.inject.AlchemyModule.Environment;
import com.strandls.alchemy.webservices.common.auth.Credentials;

/**
 * Bindings for authentication.
 *
 * @author Ashish Shinde
 *
 */
@AlchemyModule(Environment.All)
public class AuthModule extends AbstractModule {

    /**
     * Dummy credentials just for binding a request scoped provider.
     *
     * @author Ashish Shinde
     *
     */
    private static class DummyCredentials extends Credentials {

        DummyCredentials() {
            super(null, null);
        }

    }

    /*
     * (non-Javadoc)
     * @see com.google.inject.AbstractModule#configure()
     */
    @Override
    protected void configure() {
        bind(AuthenticationService.class).to(SimpleAuthenticationService.class);
        bind(Credentials.class).to(DummyCredentials.class).in(ServletScopes.REQUEST);
    }
}
