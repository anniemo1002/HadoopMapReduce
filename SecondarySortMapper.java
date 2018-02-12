import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;


public class SecondarySortMapper 
    extends Mapper<LongWritable, Text, CompositeKey, Text> {



    @Override
    /**
     * @param key is generated by Hadoop (ignored here)
     * @param value has this format: "YYYY,MM,DD,temperature"
     */
    public void map(LongWritable key, Text value, Context context) 
        throws IOException, InterruptedException {
        String line = value.toString();
        String[] tokens = line.split(",");
        String name = tokens[0].trim();
        String id = tokens[1].trim();
        String grade = tokens[2].trim();
        String course = tokens[3].trim();
        context.write(new CompositeKey(name+", "+id, grade), new Text(grade+", "+course));
    }
}