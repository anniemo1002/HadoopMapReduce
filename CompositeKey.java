import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import jdk.nashorn.internal.ir.Symbol;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

/**
 *
 * @author lubo
 */
public class CompositeKey implements Writable, WritableComparable<CompositeKey> {

    private final Text name = new Text();
    private final Text grade = new Text();

    public CompositeKey() {
    }

    public CompositeKey(String name, String grade) {
        this.name.set(name);
        this.grade.set(grade);
    }

    @Override
    public void write(DataOutput out) throws IOException {
        name.write(out);
        grade.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        name.readFields(in);
        grade.readFields(in);
    }

    @Override
    public int compareTo(CompositeKey other) {
        int result = name.compareTo(other.name);
        if (0 == result) {
            result = grade.compareTo(other.grade);
        } 
        return result;
    }

    public String getName() {
        return name.toString();
    }
    public String getGrade(){
        return grade.toString();
    }
}
