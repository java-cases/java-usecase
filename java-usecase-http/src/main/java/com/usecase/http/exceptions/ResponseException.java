/*******************************************************************************
 * 	Copyright 2016 ContainX and OpenStack4j                                          
 *
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you may not      
 * 	use this file except in compliance with the License. You may obtain a copy of    
 * 	the License at                                                                   
 *
 * 	    http://www.apache.org/licenses/LICENSE-2.0                                   
 *
 * 	Unless required by applicable law or agreed to in writing, software              
 * 	distributed under the License is distributed on an "AS IS" BASIS, WITHOUT        
 * 	WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the         
 * 	License for the specific language governing permissions and limitations under    
 * 	the License.                                                                     
 *******************************************************************************/
/******************************************************************************* 	                                                                                 
 *  Huawei has modified this source file.
 * 	Copyright 2018 Huawei Technologies Co.,Ltd.                                         
 *
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you may not      
 * 	use this file except in compliance with the License. You may obtain a copy of    
 * 	the License at                                                                   
 *
 * 	    http://www.apache.org/licenses/LICENSE-2.0                                   
 *
 * 	Unless required by applicable law or agreed to in writing, software              
 * 	distributed under the License is distributed on an "AS IS" BASIS, WITHOUT        
 * 	WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the         
 * 	License for the specific language governing permissions and limitations under    
 * 	the License.                             
 * *******************************************************************************/
package com.usecase.http.exceptions;

import com.usecase.http.StatusCode;

public class ResponseException extends Exception {

    private static final long serialVersionUID = 7294957362769575271L;

    protected StatusCode status;
    protected String body;

    public ResponseException(String message, StatusCode status) {
        super(message);
        this.status = status;
    }

    public ResponseException(String message, StatusCode status, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public ResponseException(String message, StatusCode status, String body) {
        super(message);
        this.status = status;
        this.body = body;
    }

    public static ResponseException to(String message, StatusCode status) {
        return to(message, status, null);
    }

    public static ResponseException to(String message, StatusCode status, Throwable cause) {
        if (status.getCode() == 401) {
            return new AuthenticationException(message, status, cause);
        }

        if (status.getCode() >= 400 && status.getCode() < 499) {
            return new ClientException(message, status, cause);
        }

        if (status.getCode() >= 500 && status.getCode() < 600) {
            return new ServerException(message, status, cause);
        }

        return new ResponseException(message, status, cause);
    }

    public StatusCode getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ResponseException{" +
                "status=" + status +
                ", body='" + body + '\'' +
                '}';
    }

}
