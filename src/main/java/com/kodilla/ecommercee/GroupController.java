package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.GroupDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @GetMapping
    public List<GroupDto> getAll() {
        List<GroupDto> groupDtos = new ArrayList<>();
        groupDtos.add(new GroupDto("Test name"));
        return groupDtos;
    }

    @GetMapping("/{groupId}")
    public GroupDto get(@PathVariable Long groupId) {
        return new GroupDto("test name");
    }

    @PostMapping
    public void create(GroupDto groupDto) {
    }

    @PutMapping
    public GroupDto update(GroupDto groupDto) {
        return new GroupDto("edited test title");
    }


}
