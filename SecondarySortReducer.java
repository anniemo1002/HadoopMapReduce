import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;



public class SecondarySortReducer 
    extends org.apache.hadoop.mapreduce.Reducer<CompositeKey, Text, Text, Text> {

    @Override
    protected void reduce(CompositeKey key, Iterable<Text> values, Context context) 
    	throws IOException, InterruptedException {
    	String result="";
    	for (Text value : values) {
            result += ("("+value.toString()+")"+", ");
	}
        result = result.substring(0, result.length()-2);
        context.write(new Text(key.getName()+","), new Text(result));
    }
}
