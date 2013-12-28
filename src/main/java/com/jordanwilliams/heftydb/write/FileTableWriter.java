/*
 * Copyright (c) 2013. Jordan Williams
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jordanwilliams.heftydb.write;

import com.jordanwilliams.heftydb.record.Record;
import com.jordanwilliams.heftydb.state.DataFiles;

import java.io.IOException;
import java.util.Iterator;

public class FileTableWriter {

    private final long tableId;
    private final DataFiles dataFiles;
    private final IndexWriter indexWriter;
    private final FilterWriter filterWriter;

    private FileTableWriter(long tableId, DataFiles dataFiles, long approxRecordCount) throws IOException {
        this.tableId = tableId;
        this.dataFiles = dataFiles;
        this.indexWriter = IndexWriter.open(tableId, dataFiles);
        this.filterWriter = FilterWriter.open(tableId, dataFiles, approxRecordCount);
    }

    public void write(Iterator<Record> records) throws IOException {

    }

    public void finish() throws IOException {

    }

    public static FileTableWriter open(long tableId, DataFiles dataFiles, long approxRecordCount) throws IOException {
        return new FileTableWriter(tableId, dataFiles, approxRecordCount);
    }
}
