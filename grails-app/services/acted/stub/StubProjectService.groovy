package acted.stub

import acted.core.Project
import acted.core.ProjectInterface
import acted.exception.ProjectException
import grails.transaction.Transactional

@Transactional
class StubProjectService implements ProjectInterface {

    Project createProject(Map properties) {
        Project project = new Project()

        properties.each {
            project[it.key] = it.value
        }

        return project
    }

    Project readProject(Long id) {
        Project project = new Project()
        project.id = id

        return project
    }

    Project updateProject(Project project, Map properties) {
        properties.each {
            project[it.key] = it.value
        }

        return project
    }

    boolean deleteProject(Long id) {
        return true
    }

    ProjectException testError(Project project) {
        throw new ProjectException ('Error Message', project)
    }

}
