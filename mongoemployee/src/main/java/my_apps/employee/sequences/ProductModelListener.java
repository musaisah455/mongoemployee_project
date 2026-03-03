package my_apps.employee.sequences;

import my_apps.employee.model.EmployeeModel;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class ProductModelListener extends AbstractMongoEventListener<EmployeeModel> {

    private final SequenceGeneratorService sequenceGenerator;

    public ProductModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<EmployeeModel> event) {
        if (event.getSource().getId() == null) {
            event.getSource().setId(sequenceGenerator.generateSequence(EmployeeModel.SEQUENCE_NAME));
        }
    }
}
