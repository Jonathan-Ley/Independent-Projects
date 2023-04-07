import * as cdk from "aws-cdk-lib";
import { CfnOutput, Duration } from "aws-cdk-lib";
import { Bucket, CfnBucket } from "aws-cdk-lib/aws-s3";
import { Construct } from "constructs";
//contains the actual cloud formation stacks
// import * as sqs from 'aws-cdk-lib/aws-sqs';

//way to construct a L3 bucket
class L3Bucket extends Construct {
  constructor(scope: Construct, id: string, expiration: number) {
    super(scope, id);
    new Bucket(this, "MyL3Bucket", {
      lifecycleRules: [
        {
          expiration: Duration.days(expiration),
        },
      ],
    });
  }
}

export class CdkPracticeStack extends cdk.Stack {
  //normally everything that happens within cdk is put inside constructor
  constructor(scope: Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    //creat an s3 bucket in 3 ways:
    //L1 Bucket Construct
    new CfnBucket(this, "MyL1Bucket", {
      lifecycleConfiguration: {
        rules: [
          {
            expirationInDays: 1,
            status: "Enabled",
          },
        ],
      },
    });

    const duration = new cdk.CfnParameter(this, "duration", {
      default: 6,
      minValue: 1,
      maxValue: 10,
      type: "Number",
    });

    //L2 Bucket Construct
    //a way to have objects be removed from the bucket after a certain time window
    //this example shows expiration after 2 days
    //already implies the rule status being enabled
    const myL2Bucket = new Bucket(this, "MyL2Bucket", {
      lifecycleRules: [
        {
          expiration: Duration.days(duration.valueAsNumber),
        },
      ],
    });

    //initializing a L3 bucket
    new L3Bucket(this, "MyL3Bucket", 3);
  }
}
