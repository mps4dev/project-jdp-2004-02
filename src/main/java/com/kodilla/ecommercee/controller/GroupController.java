package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<GroupDto> getAll() {
        return groupService.getAll();
    }

    @GetMapping("/{groupId}")
    public GroupDto get(@PathVariable Long groupId) {
        return groupService.getOne(groupId);
    }

    @PostMapping
    public GroupDto create(@RequestBody GroupDto groupDto) {
        return groupService.add(groupDto);
    }

    @PutMapping
    public GroupDto update(@RequestBody GroupDto groupDto) {
        return groupService.update(groupDto);
    }

}
