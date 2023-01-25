package dev.edurevsky.urlshortener.infra;

import dev.edurevsky.urlshortener.application.tasks.DeleteAllExpired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DeleteAllExpiredTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteAllExpiredTask.class);

    private final DeleteAllExpired deleteAllExpired;

    public DeleteAllExpiredTask(DeleteAllExpired deleteAllExpired) {
        this.deleteAllExpired = deleteAllExpired;
    }

    @Scheduled(fixedRate = 10_000)
    public void execute() {
        deleteAllExpired.execute(null);
        LOGGER.info("{} executed", DeleteAllExpiredTask.class.getName());
    }
}
