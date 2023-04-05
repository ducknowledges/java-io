package com.github.ducknowledges.io.processstreams;

public class StandardStream {
//    public static void main(String[] args) throws IOException {
//        File file1 = new File("input");
//        File file2 = new File("output");
//        try (FileWriter writer = new FileWriter(file1)) {
//            writer.write("Hello World!");
//        }
//
//        ProcessBuilder processBuilder1 = new ProcessBuilder("cat", "input");
//
//        try (
//                BufferedReader inputStream = new BufferedReader(
//                  new InputStreamReader(processBuilder1.start().getInputStream()));
//        ) {
//            String line;
//            while ((line = inputStream.readLine()) != null) {
//                System.out.println(line);
//            }
//        }
//
////        try (
////                BufferedReader inputStream = new BufferedReader(
////                        new FileReader("input"));
////                PrintWriter outputStream = new PrintWriter(
////                        new FileWriter("output"))
////        ) {
////            String line;
////            while ((line = inputStream.readLine()) != null) {
////                outputStream.println(line);
////            }
////        }
////
////        ProcessBuilder processBuilder2 = new ProcessBuilder("echo", "/output.txt");
//
//    }
//
//    public static void main( String[] args ) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        ReceiptDto receipt = createReceipt();
//        File file = new File("receipt.json");
//        try {
//            // Java objects to JSON file
//            mapper.writeValue(file, receipt);
//
//            // Java objects to JSON string - compact-print
//            //String jsonString = mapper.writeValueAsString(receipt);
//            //System.out.println(jsonString);
//
//            // Java objects to JSON string - pretty-print
//            //String jsonInString2 = mapper.writerWithDefaultPrettyPrinter()
//            .writeValueAsString(receipt);
//            //System.out.println(jsonInString2);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        ProcessBuilder processBuilder = new ProcessBuilder();
//        File signedFile = new File("signed-document.p7b");
//        processBuilder.command("openssl", "cms", "-sign",
//                "-nodetach", "-binary", "-in", "receipt.json", "-text",
//                "-outform", "der", "-nocerts", "-signer",
//                "src/main/resources/fiscalcert/EP52.crt",
//                "-inkey", "src/main/resources/fiscalcert/kapitalbank_prd.key");
//        Process process = processBuilder.start();
//
//        try (BufferedReader reader = new BufferedReader(
//                new InputStreamReader(process.getInputStream()));
//             PrintWriter out = new PrintWriter(
//                     new BufferedWriter(new FileWriter(signedFile)))
//        ) {
//
//
//            StringBuilder stringBuilder = new StringBuilder();
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                out.println(line);
//                stringBuilder.append(line).append("\n");
//            }
//
//            int exitVal = process.waitFor();
//            if (exitVal == 0) {
//                System.out.println("Success!");
//                System.out.println(stringBuilder.toString());
//            } else {
//                //abnormal...
//            }
//
//            try (BufferedReader reader2 = new BufferedReader(
//                    new InputStreamReader(process.getInputStream()));) {
//
//                while ((line = reader2.readLine()) != null) {
//                    stringBuilder.append(line).append("\n");
//                }
//                System.out.println(stringBuilder.toString());
//            }
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
}
