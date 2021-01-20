terraform {
  required_providers {
    aws = {
      source = "hashicorp/aws"
      version = "~> 2.70"
    }
  }
}

provider "aws" { 
  profile = "default"
  region = "us-east-2"
}

resource "aws_instance" "myinstance" { 
  ami = "ami-0a0ad6b70e61be944"
  instance_type = "t2.micro"
  key_name = "mykey"
  security_groups = [ "ssh_and_http" ]
}

resource "aws_key_pair" "mykey" {
  key_name = "mykey"
  public_key = file("terraform_ec2_key.pub")
}

resource "aws_security_group" "ssh_and_http" {
  name = "ssh_and_http"
  description = "allows ssh access on port 22 and http requests on port 8080"

  ingress {
    from_port = 8080
    to_port = 8080
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    from_port = 22
    to_port = 22
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  egress {
    from_port = 0
    to_port = 0
    protocol = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}
