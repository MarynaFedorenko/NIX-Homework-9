package nix.service;

@FunctionalInterface
public interface Block {
    void run() throws Exception;
}
