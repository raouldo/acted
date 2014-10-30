package acted.exception

import acted.core.Project

/**
 * Created by raoul on 30/10/14.
 */
class ProjectException extends RuntimeException {

    public ProjectException(String message, Project project) {
        super(message, project)
    }

}
