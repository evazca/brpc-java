/*
 * Copyright (c) 2018 Baidu, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.baidu.brpc.client.endpoint;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class EndPoint {

    private String ip;

    private int port;

    public EndPoint(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public EndPoint(String address) {
        Validate.notEmpty(address);
        String[] splits = address.split(":");
        Validate.isTrue(2 == splits.length);
        this.ip = splits[0];
        this.port = Integer.valueOf(splits[1]);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(ip)
                .append(port)
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        boolean flag = false;
        if (object != null && EndPoint.class.isAssignableFrom(object.getClass())) {
            EndPoint rhs = (EndPoint) object;
            flag = new EqualsBuilder()
                    .append(ip, rhs.ip)
                    .append(port, rhs.port)
                    .isEquals();
        }
        return flag;
    }

    @Override
    public String toString() {
        return String.format("EndPoint{\'%s:%d\'}", ip, port);
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
