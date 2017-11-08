package com.leeo.gem.monitor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sys")
public class SystemProperties {

	private String localUploadPath;

	public String getLocalUploadPath() {
		return localUploadPath;
	}

	public void setLocalUploadPath(String localUploadPath) {
		this.localUploadPath = localUploadPath;
	}

}