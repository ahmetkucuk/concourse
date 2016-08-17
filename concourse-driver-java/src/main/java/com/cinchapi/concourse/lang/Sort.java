package com.cinchapi.concourse.lang;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

/**
 * A {@link Sort} object keeps the information about sorting of
 * a query.
 *
 * @author ahmetkucuk
 */
public class Sort implements Symbol{

    /**
     * Indicates whether the state is built or not
     */
    protected boolean built = false;

    /**
     * Since the order of adding symbol indicate the way of
     * sorting the result of query, we keep symbols in order.
     */
    protected List<Symbol> listOfSortSymbols = new ArrayList<>();

    /**
     * Return a builder object for {@link Sort} object
     *
     * @return the builder
     */
    public static SortBuilder by(String key) {
        Sort sort = new Sort();
        sort.add(KeySymbol.create(key));
        return new SortBuilder(sort);
    }


    /**
     * Add symbol to {@link Sort} object even if it is in available state
     *
     * @param symbol to be added to {@link Sort} object
     */
    protected void add(Symbol symbol) {
        Preconditions.checkState(!built,
                "Cannot add a symbol to a built Sort");
        if(symbol instanceof SortSymbol ) {
            Preconditions.checkState(listOfSortSymbols.size() == 0);
            Preconditions.checkState(listOfSortSymbols.get(listOfSortSymbols.size() - 1) instanceof SortSymbol);
        }
        listOfSortSymbols.add(symbol);

    }

    /**
     * Final steps before usage of the {@link Sort} object
     */
    protected void close() {
        built = true;
    }
}
