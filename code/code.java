RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if (requestAttributes instanceof ServletRequestAttributes) {
                request = ((ServletRequestAttributes) requestAttributes).getRequest();
            }




private boolean connecstToFtpServer() throws Exception {
        boolean ftpLoginStatus = false;
        try {
            ftp = new FTPClient();
            ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
            ftp.connect(hostname, port);
            int replyCode = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                ftp.disconnect();
                return ftpLoginStatus;
            }
            logger.info("Connected to FTP SERVER, REPLYCODE ::::::: " + replyCode);
            logger.info("HOST ::::::: " + hostname);
            logger.info("PORT ::::::: " + port);
            ftpLoginStatus = ftp.login(username, password);
            if (ftpLoginStatus) {
                logger.info("Logged in with username ::::: " + username);
            } else {
                logger.info("Unable to Login :::::: ");
                return ftpLoginStatus;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ftpLoginStatus;
    }
