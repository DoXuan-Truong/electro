import React from 'react';
import { Box, createStyles, Grid, Group, Image, Stack, Text, useMantineTheme } from '@mantine/core';
import { Car, HeartHandshake, Stars } from 'tabler-icons-react';
import { ClientCarousel } from 'components';
import { motion } from 'framer-motion';

const useStyles = createStyles((theme) => ({
  rightBanner: {
    flexWrap: 'unset',
    backgroundColor: theme.colorScheme === 'dark' ? theme.colors.dark[4] : theme.colors.gray[1],
    borderRadius: theme.radius.md,
  },
  bannerImage: {
    width: '100%',
    height: '100%',
    minHeight: 315,
    objectFit: 'cover',
    borderRadius: theme.radius.md,
  },
}));

// Banner image URLs - you can change these to any image URLs
const bannerImages = [
  'https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=1200&h=400&fit=crop',
  'https://images.unsplash.com/photo-1587202372634-32705e3bf49c?w=1200&h=400&fit=crop',
  'https://images.unsplash.com/photo-1498049794561-7780e7231661?w=1200&h=400&fit=crop',
];

const container = {
  show: {
    transition: {
      staggerChildren: 0.2
    }
  }
};

const item = {
  hidden: { opacity: 0, x: 20 },
  show: { opacity: 1, x: 0 }
};

function ClientHomeBanner() {
  const theme = useMantineTheme();
  const { classes } = useStyles();

  return (
    <Grid>
      <Grid.Col md={7} lg={8}>
        <ClientCarousel>
          {bannerImages.map((imageUrl, index) => (
            <Box
              key={index}
              sx={{
                height: '100%',
                minHeight: 315,
                borderRadius: theme.radius.md,
                overflow: 'hidden',
              }}
            >
              <Image
                src={imageUrl}
                alt={`Banner ${index + 1}`}
                className={classes.bannerImage}
                withPlaceholder
              />
            </Box>
          ))}
        </ClientCarousel>
      </Grid.Col>
      <Grid.Col md={5} lg={4}>
        <motion.div variants={container} initial="hidden" animate="show">
          <Stack>
            <motion.div variants={item}>
              <Group py="sm" px="md" className={classes.rightBanner}>
                <Car size={65} strokeWidth={1} />
                <Stack spacing={theme.spacing.xs / 4}>
                  <Text size="md" weight={500} className="animate__animated animate__fadeInDown">Miễn phí vận chuyển</Text>
                  <Text size="sm">100% đơn hàng đều được miễn phí vận chuyển khi thanh toán trước.</Text>
                </Stack>
              </Group>
            </motion.div>
            <motion.div variants={item}>
              <Group py="sm" px="md" className={classes.rightBanner}>
                <Stars size={65} strokeWidth={1} />
                <Stack spacing={theme.spacing.xs / 4}>
                  <Text size="md" weight={500} className="animate__animated animate__fadeInDown">Bảo hành tận tâm</Text>
                  <Text size="sm">Bất kể giấy tờ thế nào, công ty luôn cam kết sẽ hỗ trợ khách hàng tới cùng.</Text>
                </Stack>
              </Group>
            </motion.div>
            <motion.div variants={item}>
              <Group py="sm" px="md" className={classes.rightBanner}>
                <HeartHandshake size={65} strokeWidth={1} />
                <Stack spacing={theme.spacing.xs / 4}>
                  <Text size="md" weight={500} className="animate__animated animate__fadeInDown">Đổi trả 1-1 hoặc hoàn tiền</Text>
                  <Text size="sm">Nếu phát sinh lỗi hoặc bạn cảm thấy sản phẩm chưa đáp ứng được nhu cầu.</Text>
                </Stack>
              </Group>
            </motion.div>
          </Stack>
        </motion.div>
      </Grid.Col>
    </Grid>
  );
}

export default ClientHomeBanner;
