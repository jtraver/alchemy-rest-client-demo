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

package com.strandls.alchemy.webservices.ping;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.google.inject.Provider;
import com.strandls.alchemy.webservices.common.auth.Credentials;
import com.strandls.alchemy.webservices.common.status.Status;

/**
 * A simple web service that returns the server status.
 *
 * @author Ashish Shinde
 */
@Slf4j
@Path("/ping")
@RequiredArgsConstructor(onConstructor = @_(@Inject))
public class Ping {
    /**
     * Logged in user credentials provider.
     */
    private final Provider<Credentials> credentialProvider;

    /**
     * @return A string indicating system health.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Status ping() {
        log.debug("Logged in user {}", credentialProvider.get().getUsername());
        return Status.RUNNING;
    }
}
