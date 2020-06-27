package com.zhukovsd.alfabattle.task2.analytics;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "asdf")
class UserNotFoundException extends RuntimeException {}
