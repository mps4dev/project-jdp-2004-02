package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.GroupDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @GetMapping
    public List<GroupDto> getAll() {
        return new ArrayList<>();
    }

    @GetMapping("/{groupId}")
    public GroupDto get(@PathVariable Long groupId) {
        return new GroupDto();
    }

    @PostMapping
    public void create(GroupDto groupDto) {
    }

    @PutMapping
    public GroupDto update(GroupDto groupDto) {
        return new GroupDto();
    }


}
