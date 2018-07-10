// Copyright 2017, Yahoo Holdings Inc.
// Licensed under the terms of the Apache License 2.0. Please see LICENSE file in project root for terms.
package com.yahoo.maha.maha_druid_lookups.query.lookup.namespace;

import java.util.Map;
import java.util.concurrent.Callable;

public interface ExtractionNamespaceCacheFactory<T extends ExtractionNamespace, U>
{

    Callable<String> getCachePopulator(String id, T extractionNamespace, String lastVersion, Map<String, U> swap);

    void updateCache(T extractionNamespace,
                     final Map<String, U> cache, final String key, final byte[] value);

    default byte[] getCacheValue(T extractionNamespace, Map<String, U> cache, String key, String valueColumn) {
        return new byte[0];
    }

    default String getCacheSize(T extractionNamespace, Map<String, U> cache) {
        return String.valueOf(cache.size());
    }

    default Long getLastUpdatedTime(T extractionNamespace) {
        return -1L;
    }

}
