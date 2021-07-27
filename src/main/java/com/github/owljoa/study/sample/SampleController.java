package com.github.owljoa.study.sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class SampleController {
  @Value("${name}")
  private String name;

  @GetMapping("/name")
  public String getName() {
    return "name in config file: " + name;
  }
}
