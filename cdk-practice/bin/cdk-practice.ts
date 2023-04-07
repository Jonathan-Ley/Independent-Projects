#!/usr/bin/env node
//contains code to initialize our application
import "source-map-support/register";
import * as cdk from "aws-cdk-lib";
import { PhotosStack } from "../lib/PhotosStack";

const app = new cdk.App();
//all stacks have to belong to an application
new PhotosStack(app, "PhotosStack", {});
