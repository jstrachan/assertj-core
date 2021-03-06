/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2016 the original author or authors.
 */
package org.assertj.core.internal;

import static org.assertj.core.error.uri.ShouldHaveAnchor.shouldHaveAnchor;
import static org.assertj.core.error.uri.ShouldHaveAuthority.shouldHaveAuthority;
import static org.assertj.core.error.uri.ShouldHaveHost.shouldHaveHost;
import static org.assertj.core.error.uri.ShouldHavePath.shouldHavePath;
import static org.assertj.core.error.uri.ShouldHavePort.shouldHavePort;
import static org.assertj.core.error.uri.ShouldHaveProtocol.shouldHaveProtocol;
import static org.assertj.core.error.uri.ShouldHaveQuery.shouldHaveQuery;
import static org.assertj.core.error.uri.ShouldHaveUserInfo.shouldHaveUserInfo;
import static org.assertj.core.internal.Comparables.assertNotNull;
import static org.assertj.core.util.Objects.areEqual;

import java.net.URL;

import org.assertj.core.api.AssertionInfo;
import org.assertj.core.util.VisibleForTesting;

public class Urls {

  private static final Urls INSTANCE = new Urls();

  @VisibleForTesting
  Failures failures = Failures.instance();

  public static Urls instance() {
    return INSTANCE;
  }

  Urls() {}

  public void assertHasProtocol(final AssertionInfo info, final URL actual, final String protocol) {
    assertNotNull(info, actual);
    if (!areEqual(actual.getProtocol(), protocol)) throw failures.failure(info, shouldHaveProtocol(actual, protocol));
  }

  public void assertHasPath(AssertionInfo info, URL actual, String path) {
    assertNotNull(info, actual);
    if (path == null) throw new IllegalArgumentException("Expecting given path not to be null");
    if (!areEqual(actual.getPath(), path)) throw failures.failure(info, shouldHavePath(actual, path));
  }

  public void assertHasPort(AssertionInfo info, URL actual, int expected) {
    assertNotNull(info, actual);
    if (actual.getPort() != expected) throw failures.failure(info, shouldHavePort(actual, expected));
  }

  public void assertHasHost(AssertionInfo info, URL actual, String expected) {
    assertNotNull(info, actual);
    if (!areEqual(actual.getHost(), expected)) throw failures.failure(info, shouldHaveHost(actual, expected));
  }

  public void assertHasAuthority(AssertionInfo info, URL actual, String expected) {
    assertNotNull(info, actual);
    if (!areEqual(actual.getAuthority(), expected))
      throw failures.failure(info, shouldHaveAuthority(actual, expected));
  }

  public void assertHasQuery(AssertionInfo info, URL actual, String expected) {
    assertNotNull(info, actual);
    if (!areEqual(actual.getQuery(), expected)) throw failures.failure(info, shouldHaveQuery(actual, expected));
  }

  public void assertHasAnchor(AssertionInfo info, URL actual, String expected) {
    assertNotNull(info, actual);
    if (!areEqual(actual.getRef(), expected)) throw failures.failure(info, shouldHaveAnchor(actual, expected));
  }

  public void assertHasUserInfo(AssertionInfo info, URL actual, String expected) {
    assertNotNull(info, actual);
    if (!areEqual(actual.getUserInfo(), expected)) throw failures.failure(info, shouldHaveUserInfo(actual, expected));
  }
}
