package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    public List<GroupDto> getAll() {
        List<Group> group = groupRepository.findAll();
        return groupMapper.mapToDtos(group);
    }

    public GroupDto getOne(Long id) {
        Group group = groupRepository.getOne(id);
        return groupMapper.mapToDto(group);
    }

    public GroupDto add(GroupDto dto) {
        Group group = groupMapper.mapToEntity(dto);
        Group savedGroup = groupRepository.save(group);
        return groupMapper.mapToDto(savedGroup);
    }

    public GroupDto update(GroupDto dto) {
        Optional<Group> groupOptional = groupRepository.findById(dto.getId());
        if (groupOptional.isPresent()) {
            Group group = groupOptional.get();
            group.setDescription(dto.getDescription());
            group.setName(dto.getName());
            groupRepository.save(group);
            return groupMapper.mapToDto(group);
        } else {
            throw new RuntimeException("Cannot find Group with id: " + dto.getId());
        }
    }

}
