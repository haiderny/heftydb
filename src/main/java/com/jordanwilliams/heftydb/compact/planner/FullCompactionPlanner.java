/*
 * Copyright (c) 2014. Jordan Williams
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

package com.jordanwilliams.heftydb.compact.planner;

import com.jordanwilliams.heftydb.compact.CompactionPlan;
import com.jordanwilliams.heftydb.compact.CompactionTables;
import com.jordanwilliams.heftydb.compact.CompactionTask;
import com.jordanwilliams.heftydb.table.Table;

import java.util.List;

/**
 * Compacts all tables into a single table.
 */
public class FullCompactionPlanner implements CompactionPlanner {

    private final CompactionTables tables;

    public FullCompactionPlanner(CompactionTables tables) {
        this.tables = tables;
    }

    @Override
    public CompactionPlan planCompaction() {
        CompactionTask.Builder taskBuilder = new CompactionTask.Builder(2, CompactionTask.Priority.NORMAL);

        List<Table> eligibleTables = tables.eligibleTables();

        if (eligibleTables.size() > 1) {
            for (Table table : eligibleTables){
                taskBuilder.add(table);
            }

            return new CompactionPlan(taskBuilder.build());
        }

        return null;
    }

    @Override
    public boolean needsCompaction() {
        return false;
    }
}
