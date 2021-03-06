import javax.xml.crypto.Data;
import java.util.ArrayList;

/**
 * Created by mhwong on 8/5/15.
 */
public class Dataset {
    ArrayList<Column> columns;

    public Dataset() {
        this.columns = new ArrayList<>();
    }

    public Dataset(ArrayList<Column> columns) {
        this.columns = columns;
    }

    public Dataset(Dataset dataset) { // copy constructor
        this.columns = new ArrayList<>();
        for(int i = 0; i < dataset.columns.size(); i++) {
            Column localColumn = new Column(dataset.columns.get(i));
            this.columns.add(localColumn);
        }
    }

    public void addColumn(Column column) {
        this.columns.add(column);
    }

    public Column getColumn(String attribute) {
        for(int i = 0; i < columns.size(); i++) {
            Column column = columns.get(i);
            if(column.attribute.equals(attribute)) {
                return column;
            }
        }
        return null;
    }

    public int getColumnSize() {
        return columns.size();
    }

    public int getRowSize() {
        return columns.get(0).getRowSize();
    }

    public Dataset cloneDatasetWithColumns () {
        Dataset dataset = new Dataset();
        for(int i = 0; i < this.getColumnSize(); i++) {
            Column column = new Column();
            Column shadowColumn = this.columns.get(i);
            column.type = shadowColumn.type;
            column.attribute = shadowColumn.attribute;
            dataset.columns.add(column);
        }
        return dataset;
    }

    public void clearAllRowsValue() {
        for(Column column: this.columns) {
            column.row.clear();
        }
    }

}
