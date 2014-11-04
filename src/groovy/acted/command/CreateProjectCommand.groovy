package acted.command

import acted.core.Project
import grails.validation.Validateable

/**
 * Created by raoul on 04/11/14.
 */
@Validateable
class CreateProjectCommand extends Project {

    // Toutes les propriétés sont héritées de la classe Project

    static constraints = {
        standardProjectCode nullable:true
        id nullable: false
    }
}
