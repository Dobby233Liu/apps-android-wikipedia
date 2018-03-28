package org.wikipedia.dataclient.mwapi.page;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import org.wikipedia.dataclient.mwapi.MwQueryResponse;
import org.wikipedia.dataclient.page.PageSummary;
import org.wikipedia.page.Namespace;

/**
 * Useful for link previews coming from MW API.
 */
public class MwQueryPageSummary extends MwQueryResponse implements PageSummary {
    @Override @Nullable public String getTitle() {
        if (query() == null || query().firstPage() == null) {
            return null;
        }
        return query().firstPage().title();
    }

    @Override @Nullable public String getDisplayTitle() {
        if (query() == null || query().firstPage() == null) {
            return null;
        }
        return (query().firstPage().pageProps() != null && !TextUtils.isEmpty(query().firstPage().pageProps().getDisplayTitle()))
                ? query().firstPage().pageProps().getDisplayTitle() : query().firstPage().title();
    }

    @Override @Nullable
    public String getExtract() {
        if (query() == null || query().firstPage() == null) {
            return null;
        }
        return query().firstPage().extract();
    }

    @Override @Nullable
    public String getThumbnailUrl() {
        if (query() == null || query().firstPage() == null) {
            return null;
        }
        return query().firstPage().thumbUrl();
    }

    @Override @NonNull
    public Namespace getNamespace() {
        if (query() == null || query().firstPage() == null) {
            return Namespace.MAIN;
        }
        return query().firstPage().namespace();
    }
}
