/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.spark.streaming.aliyun.sls

import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.receiver.Receiver

class LoghubInputDStream(
    @transient _ssc: StreamingContext,
    mysqlHost: String,
    mysqlPort: Int,
    mysqlDatabase: String,
    mysqlUser: String,
    mysqlPwd: String,
    mysqlWorkerInstanceTableName: String,
    mysqlShardLeaseTableName: String,
    loghubProject: String,
    logStream: String,
    loghubConsumeGroup: String,
    instanceBaseName: String,
    loghubEndpoint: String,
    accesskeyId: String,
    accessKeySecret: String,
    storageLevel: StorageLevel)
  extends ReceiverInputDStream[Array[Byte]](_ssc){
  override def getReceiver(): Receiver[Array[Byte]] =
    new LoghubReceiver(
      mysqlHost,
      mysqlPort,
      mysqlDatabase,
      mysqlUser,
      mysqlPwd,
      mysqlWorkerInstanceTableName,
      mysqlShardLeaseTableName,
      loghubProject,
      logStream,
      loghubConsumeGroup,
      instanceBaseName,
      loghubEndpoint,
      accesskeyId,
      accessKeySecret,
      storageLevel)
}
