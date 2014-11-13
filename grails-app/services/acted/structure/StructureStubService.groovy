package acted.structure

import acted.structure.StructureInterface
import acted.structure.Warehouse
import grails.transaction.Transactional

@Transactional
class StructureStubService implements StructureInterface {

    Warehouse createWarehouse(Map properties) {
        Warehouse warehouse = new Warehouse()

        properties.each {
            warehouse[it.key] = it.value
        }

        return warehouse
    }
}
