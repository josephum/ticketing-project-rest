package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.ResponseWrapper;
import com.cydeo.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getProjects() {
        List<ProjectDTO> list = projectService.listAllProjects();
        return ResponseEntity.ok(new ResponseWrapper("Projects are successfully retrieved",list, HttpStatus.OK));
    }

    @GetMapping("/{projectCode}")
    public ResponseEntity<ResponseWrapper> getProjectByCode(@PathVariable("projectCode") String projectCode) {
        ProjectDTO projectDTO = projectService.getByProjectCode(projectCode);
        return ResponseEntity.ok(new ResponseWrapper("Project is successfully retrieved",projectDTO,HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createProject(@RequestBody ProjectDTO project) {
        projectService.save(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper("Project is successfully created",HttpStatus.CREATED));

    }
//    public ResponseEntity<ResponseWrapper> updateProject() {
//
//
//    }
//    public ResponseEntity<ResponseWrapper> deleteProject() {
//
//
//    }

















}
