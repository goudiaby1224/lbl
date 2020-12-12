package com.sn.lde.ngy.lebalma.rest;


import com.sn.lde.ngy.lebalma.model.Foo;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/foos")
public class RestController {

    @GetMapping(value = "/{id}")
    public Foo findOne() {
        return new Foo(Long.parseLong(RandomStringUtils.randomNumeric(6)),
                RandomStringUtils.randomAlphabetic(4));
    }

    @GetMapping
    public List<Foo> findAll() {
        return Stream.of(new Foo(Long.parseLong(RandomStringUtils.randomNumeric(6)),
                        RandomStringUtils.randomAlphabetic(4)),
                new Foo(Long.parseLong(RandomStringUtils.randomNumeric(6)),
                        RandomStringUtils.randomAlphabetic(4)),
                new Foo(Long.parseLong(RandomStringUtils.randomNumeric(6)),
                        RandomStringUtils.randomAlphabetic(4)),
                new Foo(Long.parseLong(RandomStringUtils.randomNumeric(6)),
                        RandomStringUtils.randomAlphabetic(4))).collect(Collectors.toUnmodifiableList());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void create(@RequestBody Foo newFoo){
        LoggerFactory.getLogger(getClass()).debug("Foo create");
    }
}
