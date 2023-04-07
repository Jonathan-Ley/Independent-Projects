import * as cdk from "aws-cdk-lib";
import { Fn } from "aws-cdk-lib";
import { Bucket } from "aws-cdk-lib/aws-s3";
import { Construct } from "constructs";

export class PhotosStack extends cdk.Stack {
  private stackSuffix: string;

  constructor(scope: Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    this.initializeSuffix();
    new Bucket(this, "PhotosBucket", {
      bucketName: `photos-bucket-${this.stackSuffix}`,
    });
  }

  private initializeSuffix() {
    const shortStackId = cdk.Fn.select(2, Fn.split("/", this.stackId));
    this.stackSuffix = cdk.Fn.select(4, Fn.split("-", shortStackId));
  }
}
