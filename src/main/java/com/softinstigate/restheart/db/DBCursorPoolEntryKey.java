/*
 * RESTHeart - the data REST API server
 * Copyright (C) 2014 SoftInstigate Srl
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.softinstigate.restheart.db;

import com.mongodb.DBCollection;
import java.util.Deque;
import java.util.Objects;

/**
 *
 * @author uji
 */
public class DBCursorPoolEntryKey {
    private final DBCollection collection;
    private final Deque<String> sort;
    private final Deque<String> filter;
    private final int skipped;

    public DBCursorPoolEntryKey(DBCollection collection, Deque<String> sort, Deque<String> filter, int skipped) {
        this.collection = collection;
        this.filter = filter;
        this.sort = sort;
        this.skipped = skipped;
    }

    /**
     * @return the collection
     */
    public DBCollection getCollection() {
        return collection;
    }

    /**
     * @return the filter
     */
    public Deque<String> getFilter() {
        return filter;
    }

    /**
     * @return the sort
     */
    public Deque<String> getSort() {
        return sort;
    }
    
    /**
     * @return the skipped
     */
    public int getSkipped() {
        return skipped;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(collection, filter, sort, skipped);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DBCursorPoolEntryKey other = (DBCursorPoolEntryKey) obj;
        if (!Objects.equals(this.collection, other.collection)) {
            return false;
        }
        if (!Objects.equals(this.filter, other.filter)) {
            return false;
        }
        if (!Objects.equals(this.sort, other.sort)) {
            return false;
        }
        if (!Objects.equals(this.skipped, other.skipped)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{ collection: " + collection.getName() + ", " +
                "filter: " + (filter == null ? "null": filter.toString()) + ", " + 
                "sort: " + (sort == null ? "null": sort.toString()) + ", "  +
                "skipped: " + skipped + "}"; 
    }
}