package acted.stub

import acted.core.StructureInterface
import acted.structure.Warehouse
import grails.transaction.Transactional

@Transactional
class StubStructureService implements acted.core.StructureInterface {

    Warehouse createWarehouse(Map properties) {
        Warehouse warehouse = new Warehouse()

        properties.each {
            warehouse[it.key] = it.value
        }

        return warehouse
    }
}
