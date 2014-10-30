package acted.service

import acted.core.Project
import acted.core.ProjectInterface
import acted.exception.ProjectException
import grails.transaction.Transactional

@Transactional
class ProjectService implements ProjectInterface {

    Project createProject(Map properties) {

    }

    Project readProject(Long id) {

    }

    Project updateProject(Project project, Map properties) {

    }

    boolean deleteProject(Long id) {

    }

    ProjectException testError(Project project) {
        throw new ProjectException ('Error Message', project)
    }
}
