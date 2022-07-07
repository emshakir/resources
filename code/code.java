RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if (requestAttributes instanceof ServletRequestAttributes) {
                request = ((ServletRequestAttributes) requestAttributes).getRequest();
            }
