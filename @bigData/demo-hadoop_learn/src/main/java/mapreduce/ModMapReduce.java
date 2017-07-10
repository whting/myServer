package mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

public class ModMapReduce {

    /**
     * Driver
     *
     * 如:FileAlreadyExistsException: Output directory hdfs://localhost:9000/user/Administrator/output already exists
     * 则:hadoop fs -rm -r output
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        args = new String[]{
                "hdfs://10.1.16.251:8020/user/hyman/mr/wc/input",
                "hdfs://10.1.16.251:8020/user/hyman/mr/wc/module-output"
        };
        args = new String[]{"input", "module-output"};

        Configuration conf = new Configuration();// set conf
        conf.set("mapreduce.job.ubertask.enable", "false");
        Job job = Job.getInstance(conf,ModMapReduce.class.getSimpleName());// create job
        job.setJarByClass(ModMapReduce.class);// set class

        /******************* set job ***/
        // 1) set input
        job.setInputFormatClass(TextInputFormat.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));

        // 2) set map
        job.setMapperClass(ModMapper.class);
        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(Text.class);

        // 3) set shuffle
//		job.setPartitionerClass(HashPartitioner.class);
//		job.setSortComparatorClass(LongWritable.Comparator.class);
//		job.setCombinerClass(ModuleReducer.class);
//		job.setGroupingComparatorClass(LongWritable.Comparator.class);

        // 4) set reduce
        job.setReducerClass(ModReducer.class);
        job.setOutputKeyClass(LongWritable.class);
        job.setOutputValueClass(Text.class);

        // 5) set output
        job.setOutputFormatClass(TextOutputFormat.class);
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // submit job
        boolean isSuccess = job.waitForCompletion(true);

        // exit program
        System.exit(isSuccess ? 0 : 1);
    }
}

// Mapper class
class ModMapper extends
        Mapper<LongWritable, Text, LongWritable, Text> {
    @Override
    protected void setup(Context context) throws IOException,
            InterruptedException {
        super.setup(context);
    }

    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        // TODO core things
        System.out.println(key + ":" + value);
        super.map(key, value, context);
    }

    @Override
    protected void cleanup(Context context) throws IOException,
            InterruptedException {
        super.cleanup(context);
    }
}

// Reducer class
class ModReducer extends
        Reducer<LongWritable, Text, LongWritable, Text> {
    @Override
    protected void setup(Context context) throws IOException,
            InterruptedException {
        super.setup(context);
    }

    @Override
    protected void reduce(LongWritable key, Iterable<Text> values,
                          Context context) throws IOException, InterruptedException {
        // TODO core things
        super.reduce(key, values, context);
    }

    @Override
    protected void cleanup(Context context) throws IOException,
            InterruptedException {
        super.cleanup(context);
    }
}