package com.cinchapi.concourse.lang;

/**
 * Builder class for {@link Sort} class.
 *
 * @author ahmetkucuk
 */
public class SortBuilder {

    /**
     * A reference to the {@link Sort} that is being built.
     */
    protected final Sort sort;

    public SortBuilder(Sort sort) {
        this.sort = sort;
    }

    /**
     * Adds another key value to be sorted according to.
     *
     * @return the builder
     */
    public SortBuilder and(String key) {
        sort.add(KeySymbol.create(key));
        return new SortBuilder(sort);
    }

    /**
     * Add {@link SortSymbol} to indicate that previously added
     * key symbols will be sort in ascending order.
     *
     * @return the builder
     */
    public SortBuilder asc() {
        sort.add(SortSymbol.ASC);
        return new SortBuilder(sort);
    }

    /**
     * Add {@link SortSymbol} to indicate that previously added
     * key symbols will be sort in descending order.
     *
     * @return the builder
     */
    public SortBuilder desc() {
        sort.add(SortSymbol.DESC);
        return new SortBuilder(sort);
    }

    /**
     * Builts {@link Sort} object to do this it closes the state
     * in the sort object.
     *
     * @return the {@link Sort} object
     */
    public Sort build() {
        sort.close();
        return sort;
    }
}
