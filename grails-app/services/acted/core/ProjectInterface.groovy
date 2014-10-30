package acted.core

import acted.core.Project
import acted.exception.ProjectException

/**
 * Created by raoul on 30/10/14.
 */
interface ProjectInterface {

    Project createProject(Map properties)

    Project readProject(Long id)

    Project updateProject(Project project, Map properties)

    boolean deleteProject(Long id)

    ProjectException testError(Project project)

}